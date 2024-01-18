class Solution {
public:
    bool isPalindrome(int x) {
        std::string num = std::to_string(x);
        const int len = num.length();
        int i = 0, j = len - 1;
        while (i < j) {
          if (num[i] != num[j]) return false;
          i++;
          j--;
        }
        return true;
    }
};
