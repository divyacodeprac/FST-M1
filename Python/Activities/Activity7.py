numberofElements = int(input("Enter the number of list size"))
elementList = []
for i in range(0,numberofElements) :
    element = int(input("Enter element"))
    elementList.append(element)
    print(elementList)
sum = 0
for j in range(0,len(elementList)):
    sum = sum + elementList[j]
print(sum)