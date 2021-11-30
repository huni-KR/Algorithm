x = input()

tmp = 0
cnt = 0
while len(x) != 1:
    cnt += 1
    for i in range(len(x)):
        tmp += int(x[i])
    x = str(tmp)
    tmp = 0

print(cnt)
if int(x) % 3 == 0:
    print('YES')
else:
    print('NO')
