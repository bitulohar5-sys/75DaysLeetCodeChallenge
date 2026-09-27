class Solution {
public:

    bool isPalindrome(const string& s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right])
                return false;

            left++;
            right--;
        }

        return true;
    }

    vector<vector<int>> palindromePairs(vector<string>& words) {

        unordered_map<string, int> mp;

        
        for (int i = 0; i < words.size(); i++) {
            mp[words[i]] = i;
        }

        vector<vector<int>> ans;

        for (int i = 0; i < words.size(); i++) {

            string word = words[i];
            int n = word.length();

            for (int cut = 0; cut <= n; cut++) {

                string left = word.substr(0, cut);
                string right = word.substr(cut);

             
                if (isPalindrome(word, 0, cut - 1)) {

                    string revRight = right;
                    reverse(revRight.begin(), revRight.end());

                    if (mp.count(revRight)) {

                        int j = mp[revRight];

                        if (i != j) {
                            ans.push_back({j, i});
                        }
                    }
                }

               
                if (cut != n && isPalindrome(word, cut, n - 1)) {

                    string revLeft = left;
                    reverse(revLeft.begin(), revLeft.end());

                    if (mp.count(revLeft)) {

                        int j = mp[revLeft];

                        if (i != j) {
                            ans.push_back({i, j});
                        }
                    }
                }
            }
        }

        return ans;
    }
};