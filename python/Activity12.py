def Sum(num1):
  if num1:
    # Recursive function call
    return num1 + Sum(num1-1)
  else:
    return 0

# Call calculateSum() function
res = Sum(20)
# Print result
print(res)
