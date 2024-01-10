from openai import OpenAI
import os
from dotenv import load_dotenv
from fastapi import FastAPI, HTTPException
import uvicorn

load_dotenv()


OPENAI_API_KEY = os.getenv("OPENAI_API_KEY")
client = OpenAI()
client.api_key = OPENAI_API_KEY
PROMPT = os.getenv("PROMPT")

app = FastAPI()


async def generate_quiz_questions(course_content):
    print("Generating quiz questions...")
    try:
        response = client.chat.completions.create(
            model="gpt-3.5-turbo",
            messages=[
                {
                    "role": "system",
                    "content": PROMPT
                },
                {
                    "role": "user",
                    "content": course_content
                },
                {
                    "role": "system",
                    "content": "donner les corrections des questtions."
                }
            ]
        )

        # Extract questions and answers from the ChatGPT response
        choices = response['choices']
        # Skip the last message (system prompt)
        questions = [choice['message']['content'] for choice in choices[:-1]]
        correct_answers = choices[-1]['message']['content'].split('\n')

        return questions, correct_answers

    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))


@app.get("/info")
async def get_info(stf: str):
    


    # Generate quiz questions and correct answers based on the course content
    quiz_questions, correct_answers = await generate_quiz_questions(stf)

    # Create a list of quiz questions with correct answers
    quiz = [{"question": question, "answers": ["Option A", "Option B", "Option C", "Option D"],
             "correct_answer": correct_answers[i]} for i, question in enumerate(quiz_questions)]

    return {"quiz": quiz}

if __name__ == "__main__":
    uvicorn.run("main:app", host="localhost", port=8080, reload=True)
