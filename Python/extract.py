with open("lte_tbc2i.csv","r",encoding='utf-8')as f:
    lines=f.readlines()

with open("out.txt","w",encoding='utf-8')as f:
    for line in lines:
        line=line.split(',')
        new_line=line[1]+' '+line[2]+' '+line[4]+'\n'
        f.write(new_line)
