num_student = int(input())
student_list = []

for i in range(num_student):
    student_list.append(input().split())
for i in student_list:
    rank = 1
    for j in student_list:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1
    print(rank, end =" ")
