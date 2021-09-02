import sys

def print_text(input, cat):
    cat = int(cat)
    print (cat)
    return ("Dette er det du skrev: " + input)

i = sys.argv[1]
j = sys.argv[2]
print (print_text(i, j))

#print ("hei hei")
