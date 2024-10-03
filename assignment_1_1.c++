#include <iostream>
#include <vector>
using namespace std;

void insertion_sort(vector<int> &arr)
{
    for (int i = 1; i < arr.size(); i++)
    {
        int current = arr[i];
        int j = i-1;
        while (j >= 0 && current < arr[j])
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
    }
}

void bubble_sort(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = 0; j < arr.size()-1-i; j++)
        {
            if (arr[j+1]<arr[j])
            {
                int temp = arr[j+1];
                arr[j+1] = arr[j]; 
                arr[j] = temp;
            }
        }
    }
}

vector<int> merged(const vector<int> &arr1, const vector<int> &arr2)
{
    vector<int> sorted;
    int i = 0, j = 0;

    while(i < arr1.size() && j < arr2.size())
    {
        if (arr1[i] < arr2[j])
        {
            if (sorted.empty() || sorted.back() != arr1[i]) sorted.push_back(arr1[i]);
            i++;
        }
        else if (arr2[j] < arr1[i])
        {
            if (sorted.empty() || sorted.back() != arr2[j]) sorted.push_back(arr2[j]);
            j++;
        }
        else 
        {
            if (sorted.empty() || sorted.back() != arr1[i]) sorted.push_back(arr1[i]);
            i++; j++;
        }
    }
    while (i < arr1.size())
    {
        if (sorted.empty() || sorted.back() != arr1[i]) 
            sorted.push_back(arr1[i]);
            i++;
    }
    while (j < arr2.size())
    {
        if (sorted.empty() || sorted.back() != arr2[j]) 
            sorted.push_back(arr2[j]);
            j++;
    }
    return sorted;
}

int binary_search(const vector<int> &arr, int target)
{
    int left = 0;
    int right = arr.size()-1;
    while (left <= right)
    {
        int mid = left + (right-left)/2;
        if (arr[mid] == target) return mid;
        else if (target < arr[mid]) right = mid-1;
        else left = mid+1;
    }
    return -1;
}
int main()
{
    vector<int> arr1 = {8,2,4,10,16,6,8};
    vector<int> arr2 = {9,7,5,11,17,19,1,3};
    
    insertion_sort(arr1);
    bubble_sort(arr2);
    vector<int> combined = merged(arr1,arr2);

    for (int i = 0; i < combined.size(); i++)
    {
        cout<<combined[i]<<" ";
    }
    cout<<endl;


    int target = 17;
    int index = binary_search(combined, target);

    cout<<index;

    cout<<endl;
    return 0;
}

