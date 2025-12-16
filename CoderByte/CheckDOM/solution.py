def CheckDOM(strParam):

  # code goes here

  # print('\n --- start ----')

  stack = []

  i = 0
  while i < len(strParam):
    
    # print(strParam[i], end=",")

    # getting closing tags
    # if i < len(strParam) - 1 and strParam[i] == '<' and strParam[i+1] == '/':
    #   start = i+1
    #   end = 0
    #   while strParam[i] != '>':
    #     i += 1
    #   print('close tag', strParam[start:i])


    if strParam[i] == '<':
      if i < len(strParam) - 1 and strParam[i+1] == '/':
        start = i+1
        end = 0
        while strParam[i] != '>':
          i += 1
        # print('\n - close tag', strParam[start:i])
        close_tag = strParam[start+1:i]

        # print('stripped close tag:', close_tag)

        # if len(stack) > 0 and stack.pop() != close_tag:
        #     print('wrong tags', close_tag)
        #     break

        if len(stack) > 0 and close_tag == stack[-1]:
          stack.pop()
        else:
          # print('wrong tags', close_tag)
          if len(stack) == 1: return stack[0]
          return False

      else:
        start = i+1
        end = 0
        while strParam[i] != '>':
          i += 1
        # print('\n - open tag', strParam[start:i])
        open_tag = strParam[start:i]
        # append the openning tags to the stack
        stack.append(open_tag)
    
    i += 1

    # print('> stack:', stack)

  if len(stack) == 0: return True

  if len(stack) == 1: return stack[0]

  return False

# keep this function call here 
print(CheckDOM(input()))

