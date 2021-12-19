from operator import le

numBuyer = int(input())
offer = [] #size,payment,buyerId
for i in range(numBuyer):
    temp = list(map(int, input().split()))
    for j in range(temp[0]):
        offer.append([temp[2*j+1],temp[2*j+2],i+1])
numScenario = int(input())
temp = list(map(int,input().split()))
scenario = [] # target.revenue, targetId
for i in range(numScenario):
    scenario.append([temp[i],i+1])
# print(numBuyer)
# print(offer)
# print(numScenario)
# print(scenario)

# 정렬은 인덱스의 순서별로 정렬함. 소트의 정렬이 가장 길다.
offer.sort()
scenario.sort()

# print(offer)
# print(scenario)

revenue = 0
buyerPayment = [0]*(numBuyer+1) # numBuyer+1만큼 0 으로 초기화
sIdx = 0
for i in range(len(offer)):
    size = offer[i][0]
    payment = offer[i][1]
    buyerId = offer[i][2]
    if payment > buyerPayment[buyerId]:
        revenue += -buyerPayment[buyerId] + payment
        buyerPayment[buyerId] = payment
    while sIdx < numScenario and scenario[sIdx][0] <= revenue:
        scenario[sIdx].append(size)
        sIdx += 1
while sIdx < numScenario:
    scenario[sIdx].append(-1)
    sIdx += 1
scenario.sort(key= lambda x:x[1])
for i in range(len(scenario)):
    print(scenario[i][2],end=' ')
