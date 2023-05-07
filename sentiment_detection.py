from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer
import openai
sentiment = SentimentIntensityAnalyzer()

'''
•(Done) Intent - Greetings, Question/answer, Task Completion, Decision Making Advice
•(Done) Topic - Relationship advice, Philosophy, Career guidance, Health and wellness, ritualistic section, Balance between material life and Spritual life
•(Done) Sentiment- Positive, Negative, Neutral
•(Done) Opinion- Positive, Negative, Neutral
'''

openai.api_key = "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"
#text = input("You: ")

def ask_question(prompt):
    response = openai.Completion.create(
        engine="text-davinci-002",
        prompt=prompt,
        temperature=0.3,
        max_tokens=50,
        top_p=1,
        frequency_penalty=0,
        presence_penalty=0
    )
    return response.choices[0].text.strip()

def detectSentiment(text):
    sent = sentiment.polarity_scores(text)
    if sent["compound"] > 0.05:
        return "positive"
    elif sent["compound"] < -0.05:
        return "negative"
    else:
        return "neutral"


def detectTopic(text):
    prompt = f"Respond with the topic (Relationship advice, Philosophy, Career guidance, Health and wellness, ritualistic section) of the text: '{text}'\nResponse:"
    return ask_question(prompt)

def detectIntent(text):
    prompt = f"Respond with the intent (Greetings, Question Answering, Task Completion, Decision Making Advice) of the text: {text}\nResponse:"
    return ask_question(prompt)

def detectOpinion(text, prev_message):
    prompt = f"Respond with the opinion (Positive, Negative or Neutral) of the user in the following situation:\nChatbot: {prev_message}\nUser: {text}\n\nResponse: "
    return ask_question(prompt)