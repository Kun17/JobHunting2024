class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        const int len = nums.size();
        int two_sums[len][len];
        unordered_map<int, vector<int>> value_index_map;
        for (int i = 0; i < len; i++) {
          value_index_map[nums[i]].push_back(i);
          for (int j = i; j < len; j++) {
            two_sums[i][j] = nums[i] + nums[j];
          }
        }
        set<vector<int>> res_temp;
        for (int i = 0; i < len; i++) {
          for (int j = i; j < len; j++) {
            auto it = value_index_map.find(-two_sums[i][j]);
            if (it == nullptr) continue;
            for (const auto k : it->second) {
              if (k > i && k > j) {
                res_temp.insert({nums[i], nums[j], nums[k]});
              }
            }
          }
        }
      return {res_temp.begin(), res_temp.end()};
    }
};
