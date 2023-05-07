import openai
import os

# set up API key
openai.api_key = os.environ['openai_api_key']

# define function to prompt GPT-3 API to ask a question
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

# main function that interacts with the user
def ask(user_input):
    prompt1 = f"Paraphrase (you/yours) {user_input} and ask why/how/what user actually wants to say (ask question compassionately)\nQuestion:"
        #prompt2 = f"If the phrase '{user_input}' indicates some mental or physical illness then respond with a one or two liner supportive sentence which suits most with the phrase '{user_input}'.\nResponse:"
        #question2 = ask_question(prompt2)
    question1 = ask_question(prompt1)
    return question1