#!/usr/bin/env python3
"""
Complete Agent Example

This script demonstrates the agent using features from all 12 lessons.
It's meant as a reference for how the pieces fit together.
"""

import time
from agent.agent import Agent


def lesson_01_basic_chat():
    print("="*50)
    print("LESSON 01: Basic LLM Chat")
    print("="*50)

    agent = Agent("models/llama-3-8b-instruct.gguf")
    question = input("Please enter your question\n")
    response = agent.simple_generate(question)
    for i in range(1):
        print(response)

def main():
    """Run all lesson examples"""
    print("\n" + "#"*50)
    print("# AI Agent Examples - All Lessons")
    print("#"*50)
    
    try:
        # Comment out lessons you want to skip
        lesson_01_basic_chat()
        # lesson_02_with_role()
        # lesson_03_structured()
        # lesson_04_decisions()
        # lesson_05_tools()
        # lesson_06_agent_loop()
        # lesson_07_memory()
        # lesson_08_planning()
        # lesson_09_atomic_actions()
        # lesson_10_aot()
        # lesson_11_evals()
        # lesson_12_telemetry()
        
        print("\n" + "="*50)
        print("All examples completed!")
        print("="*50)
        
    except FileNotFoundError as e:
        print(f"\n❌ Error: {e}")
        print("\nMake sure you have:")
        print("1. Downloaded a GGUF model")
        print("2. Placed it in the models/ directory")
        print("3. Updated the model path in this script")
    except Exception as e:
        print(f"\n❌ Unexpected error: {e}")

main()