import openai

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

def chatbot(user_input):
    prompt = f"Extract keywords from '{user_input}'\n\nOutput:"
    return ask_question(prompt).split(',')

#print(chatbot(input("Enter: ")))