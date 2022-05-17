
inpstr = input ("Enter comma-separated string: ")
num_tuple = tuple(inpstr.split (","))
print(num_tuple[0])
for x in num_tuple:
    if(int(x)%5==0):
        print(x)