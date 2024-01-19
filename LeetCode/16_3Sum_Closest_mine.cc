class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        const int len = nums.size();
        int res = 0;
        int min_gap = INT_MAX;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int gap = nums[i] + nums[j] + nums[k] - target;
                if (abs(gap) <= abs(min_gap)) {
                    min_gap = gap;
                } else {
                    break;
                }
                if (gap == 0) {
                    return target;
                } else if (gap > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return target + min_gap;
    }
};
