def sum(n):
    result = 0
    for j in range(0,len(numList)) :
      result = result + int(numList[j])
     
    return result
  
num = int(input("Enter a number of elements in list: "))
numList = []
for i in range(0,num):
    element = int(input("Enter the element"))
    numList.append(element)
print("The sum is: ", sum(numList))