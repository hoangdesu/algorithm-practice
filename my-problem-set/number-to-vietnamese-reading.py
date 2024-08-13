def numberToVietnameseReading(num: int) -> str:
    vietnamese_readings = {
        '0': 'không',
        '1': 'một',
        '2': 'hai',
        '3': 'ba',
        '4': 'bốn',
        '5': 'năm',
        '6': 'sáu',
        '7': 'bảy',
        '8': 'tám',
        '9': 'chín',
    }

    reading = ''
    for char in str(num):
        reading += f'{vietnamese_readings[char]} '
    
    return reading.strip().title()



# constrained to millions
print(numberToVietnameseReading(18))       # mười tám
print(numberToVietnameseReading(246))      # hai trăm bốn mươi sáu
print(numberToVietnameseReading(26295))    # hai mươi sáu nghìn hai trăm chín mươi LĂM
print(numberToVietnameseReading(41505))    # bốn mươi MỐT nghìn năm trăm LINH NĂM


test_num = 26295
test_num_str = str(test_num)
length = len(test_num_str)
end_pointer = length - 1

print(length % 3)
