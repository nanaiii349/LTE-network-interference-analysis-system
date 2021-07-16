with open("lte_tbcell.csv","r",encoding='utf-8')as f:
    lines=f.readlines()

with open("cordinate.txt","w",encoding='utf-8')as f:
    cor_dict = {}
    for line in lines:
        line=line.split(',')
        cor_dict[line[1]]=[float(line[11]),float(line[12])]
    f.write(str(cor_dict))