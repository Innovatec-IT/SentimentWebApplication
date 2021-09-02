from transformers import BertTokenizer
import torch
import sys

from BertSentimentModel import BERTSentiment

def two_categories(input):

    base_language_model = "NbAiLab/nb-bert-base"

    tokenizer = BertTokenizer.from_pretrained(base_language_model)
    tokenized_text = tokenizer(input, return_tensors="pt")

    new_model_path = "/home/kari_eriksen/models/model-two-cat/model.bin"
    # TODO add correct path to model, general path

    model = BERTSentiment(base_language_model, 2)
    model.load_state_dict(torch.load(new_model_path, map_location=torch.device('cpu')))
    model.eval()

    output = model(**tokenized_text)
    score = torch.max(output, 1).indices.item()
    if score == 0:
        output = "negativ"
    elif score == 1:
        output = "positiv"
    else:
        output = "none"

    return output

def three_categories(input):

    base_language_model = "NbAiLab/nb-bert-base"

    tokenizer = BertTokenizer.from_pretrained(base_language_model)
    tokenized_text = tokenizer(input, return_tensors="pt")

    new_model_path = "/home/kari_eriksen/models/model-three-cat/model.bin"
    # TODO add correct path to model, general path

    model = BERTSentiment(base_language_model, 3)
    model.load_state_dict(torch.load(new_model_path, map_location=torch.device('cpu')))
    model.eval()

    output = model(**tokenized_text)
    score = torch.max(output, 1).indices.item()
    if score == 0:
        output = "negativ"
    elif score == 1:
        output = "nøytral"
    elif score == 2:
        output = "positiv"
    else:
        output = "none"

    return output

def predict(input, category):

    if category == 2:
        output = two_categories(input)
    elif category == 3:
        output = three_categories(input)
    else:
        output = "none"

    return output


if len(sys.argv) >= 3:
    user_input = sys.argv[1]
    user_input = str(user_input)
    category = sys.argv[2]
    category = int(category)
    s = predict(user_input, category)
    print (s)
else:
    print ("No text was given, model can not predict sentiment without text.")
