from pickle import FALSE, TRUE


fuitbasket =	{ "apples": 100,
  "plums": 200,
  "mangoes": 350,
  "pineapple":400
}
fruitPresent = False
searchFruit= input("Enter the fruit name to be present in basket").lower()
if(searchFruit in fuitbasket) :
    fruitPresent = True
print(fruitPresent)
if(fruitPresent) :
    print(searchFruit + "is present in fruitbasket")
else: 
    print(searchFruit + "is not present in fruitbasket")