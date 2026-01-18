"""
The Agent - This file grows across all 10 lessons.

This is the heart of the repository. Each lesson adds exactly one capability
to this agent, building understanding progressively.

Lesson progression:
01: Basic LLM chat
02: System prompts (roles)
03: Structured outputs (JSON)
04: Decision-making
05: Tool calling
06: Agent loop
07: Memory
08: Planning
09: Atomic actions
10: AoT (Atom of Thought)
"""

from typing import Any

from shared.llm import LocalLLM
from shared.utils import extract_json_from_text
from agent.state import AgentState
from agent.memory import Memory
from agent.tools import get_tool_schema, execute_tool
from agent.planner import create_plan, create_atomic_action, create_aot_graph, execute_graph


class Agent:
    
    def __init__(self, model_path: str):
        # Lesson 01: Basic LLM interaction
        self.llm = LocalLLM(model_path)
    
    #Lesson1: Basic LLM Chat
    def simple_generate(self, user_input: str) -> str:
        return self.llm.generate(user_input)
    

    # Main run method
    def run(self, user_input: str) -> str:
        result = self.run_with_memory(user_input)
        
        if result and "reply" in result:
            return result["reply"]

        return self.generate_with_role(user_input)