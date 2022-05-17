from multiprocessing import RLock


user1 = input("User1 name ")
user2 = input("User2 name ")

user1_answer = input(user1 + "choose rock , scissors, paper").lower()
user2_answer = input(user2 + "choose rock , scissors, paper").lower()

if user1_answer == user2_answer:
	 print("It's a tie!")
elif user1_answer=='rock':
    if user2_answer=='scissors':
        print("Rock wins")
    else:
        print("Paper wins")
elif user1_answer=='paper':
    if user2_answer=='rock':
        print("Rock wins")
    else :
        print("Scissors win")
elif user1_answer=='Scissors':
    if user2_answer=='Paper':
        print("Scissors wins")
    else:
        print("Rock wins")
else:
    print("It is an invalid option")