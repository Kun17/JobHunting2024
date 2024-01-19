class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        const int len = nums.size();
        set<vector<int>> res_temp;
        for (int i = 0; i < len; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res_temp.insert({nums[i], nums[j], nums[k]});
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return {res_temp.begin(), res_temp.end()};
    }
};
