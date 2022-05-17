
inpstr = input ("Enter comma-separated string: ")
listofElements = list(inpstr.split (","))
firstElement = listofElements[0]
lastElement = listofElements[-1]
print(firstElement)
print(lastElement)
if(firstElement==lastElement):
    print(True)
else : 
    print(False)