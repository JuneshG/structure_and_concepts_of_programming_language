# Insertion Sort
def insertion_sort(arr):
    for i in range(1, len(arr)):
        current = arr[i]
        j = i - 1
        while j >= 0 and current < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = current
    return arr

# Bubble Sort
def bubble_sort(arr):
    n = len(arr)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

# Merge two sorted arrays
def merge(arr1, arr2):
    i, j = 0, 0
    merged = []
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            if not merged or merged[-1] != arr1[i]:
                merged.append(arr1[i])
            i += 1
        else:
            if not merged or merged[-1] != arr2[j]:
                merged.append(arr2[j])
            j += 1

    while i < len(arr1):
        if not merged or merged[-1] != arr1[i]:
            merged.append(arr1[i])
        i += 1

    while j < len(arr2):
        if not merged or merged[-1] != arr2[j]:
            merged.append(arr2[j])
        j += 1

    return merged

# Binary Search
def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif target < arr[mid]:
            right = mid - 1
        else:
            left = mid + 1
    return -1

# Input from user
size1 = int(input("Enter size of arr1: "))
arr1 = [int(input(f"index {i}: ")) for i in range(size1)]

size2 = int(input("Enter size of arr2: "))
arr2 = [int(input(f"index {i}: ")) for i in range(size2)]

# Sorting and Merging
arr1_sorted = insertion_sort(arr1)
bubble_sort(arr2)
merged_array = merge(arr1_sorted, arr2)

# Binary Search for 5 in the merged array
target = 5
index = binary_search(merged_array, target)

# Output results
print(f"Sorted arr1: {arr1_sorted}")
print(f"Sorted arr2: {arr2}")
print(f"Merged array: {merged_array}")
if index != -1:
    print(f"Target {target} found at index {index}")
else:
    print(f"Target {target} not found in the merged array")
