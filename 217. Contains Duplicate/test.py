table = {}
table[2] = 2
# print(table[3]) # will give key error

if 2 in table:
    print('has')
else:
    print('no have')
    
    
for key in table.keys():
    print(key)