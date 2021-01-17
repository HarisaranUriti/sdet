number = int(input("Enter any integer:"))
rem = number%2
print(rem)
number = str(number)
if rem == 0:
    print (number + " is an even number")
else:
    print (number + " is an odd nmber")
