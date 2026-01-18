from shared.llm import LocalLLM

class Agent:
    def __init__(self, model_path: str):
        self.llm = LocalLLM(model_path)

    def simple_generate(self, user_input: str) -> str:
        return self.llm.generate(user_input)