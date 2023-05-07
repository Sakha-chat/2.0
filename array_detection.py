from sentiment_detection import detectSentiment, detectTopic, detectIntent, detectOpinion
import json
from keyword_extract import chatbot
from ask_more_context import ask
from flask import Flask, request, jsonify

with open("sakhaE.json", "r", encoding="utf-8") as f:
    dataset = json.load(f)
    dataset = dataset["sakhaE"]

app = Flask(__name__)

@app.route('/',methods=['GET'])
def welcomePage():
    return "Welcome to Sakha Model API"

@app.route('/predict', methods=['POST'])
def home():
    req = request.get_json()
    data=json.loads(req)
    user_keyword = data.get("user_keyword")
    user_input=data['userInput']
    prev_message=data.get('prevMessage')
    print(type(user_input))
    print(type(prev_message))
    # user_keyword=[]
    opinion = detectOpinion(user_input, prev_message)
    sentiment = detectSentiment(user_input)
    topic = detectTopic(user_input)
    intent = detectIntent(user_input)
    temp = chatbot(user_input)
    for i in temp:
        user_keyword.append(i.strip().lower())
    user_keyword = list(set(user_keyword))
    #print(user_keyword)
    prev_final = 0
    r_score = 0
    response = None
    for data in dataset:
        rest_score = 0
        score = 0
        data_keyword = data['keywords']
        for i in user_keyword:
            for j in data_keyword:
                i = i.lower()
                j = j.strip().lower()
                special = "~`!@#$%^&*()_-+=[]}{|\;:'/?><.,"
                for x in special:
                    i = i.replace(x,"")
                    j = j.replace(x,"")
                if i == j:
                    score = score + 1

        final = (100*score)/len(data_keyword)
        if (topic.lower() in data['topic'].lower()) or (data['topic'].lower() in topic.lower()):
            rest_score = rest_score + 1

        if (intent.lower() in data['intent'].lower()) or (data['intent'].lower() in intent.lower()):
            rest_score = rest_score + 1

        if (data['sentiment'].lower() in sentiment.lower()) or (sentiment.lower() in data['sentiment'].lower()):
            rest_score = rest_score + 1

        if (data['opinion'].lower() in opinion.lower()) or (opinion.lower() in data['opinion'].lower()):
            rest_score = rest_score + 1

        if final >= prev_final and rest_score >= r_score:
            response = data["response"]
            prev_final = final
            r_score = rest_score
            m_topic =  topic
            m_intent = intent
            m_opinion = opinion
            m_sentiment = sentiment
        # return jsonify({"answer":response})
    if response and prev_final >= 20 and r_score >= 2:
        return jsonify({"answer": response, "user_keyword": [], "prev_final": prev_final, "r_score": r_score})
    else:
        prev_message = ask(user_input)
        return jsonify({"answer": prev_message, "user_keyword": user_keyword, "prev_final": prev_final, "r_score": r_score, "m_topic": m_topic, "m_opinion":m_opinion, "m_sentiment": m_sentiment, "m_intent": m_intent})
    
if __name__ == '__main__':
    app.run('127.0.0.1',8090)