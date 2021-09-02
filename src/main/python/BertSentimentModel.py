from transformers import BertModel
import torch.nn as nn

class BERTSentiment(nn.Module):
    def __init__(self, model_select, number_of_categories):
        super(BERTSentiment, self).__init__()
        self.model_select = model_select
        self.number_of_categories = number_of_categories
        self.bert = BertModel.from_pretrained(self.model_select)
        self.classifier = nn.Linear(768, self.number_of_categories)

    def forward(self, input_ids, attention_mask, token_type_ids):
        _, outputs = self.bert(input_ids, attention_mask=attention_mask, token_type_ids=token_type_ids, return_dict=False)
        final_outputs = self.classifier(outputs)

        return final_outputs
