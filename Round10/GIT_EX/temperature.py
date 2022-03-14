
def main():

    command = input("Select transform direction (CF) or (FC): ")

    try:
        input_temp = float(input("Input temperature: "))
    except:
        print("Not valid input")
        exit()


    if command == "CF":
        print("{} C = {} F".format(input_temp, "{:.1f}".format(t_transform(input_temp, 'c'))))
    if command == "FC":
        print("{} F = {} C".format(input_temp, "{:.1f}".format(t_transform(input_temp, 'f'))))






def t_transform(temp, type):

    if type == 'c':
        return float(temp * 9/5 + 32)
    if type == 'f':
        return float((temp - 32)/(9/5))

    return None


if __name__ == "__main__":
    main()
