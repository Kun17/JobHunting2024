class Solution {
public:
    int maxArea(vector<int>& height) {
        const int len = height.size();
        int i = 0, j = len - 1, res = 0;
        while (i < j) {
            res = std::max(std::min(height[i], height[j]) * (j - i), res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
};
