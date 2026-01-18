from agent.agent import Agent

def lesson_01_basic_chat():
    """Lesson 01: Basic LLM interaction"""
    print("\n" + "="*50)
    print("LESSON 01: Basic LLM Chat")
    print("="*50)
    
    agent = Agent("models/llama-3-8b-instruct.gguf")
    response = agent.simple_generate("Explain what an AI agent is?")
    print(f"Response: {response}")