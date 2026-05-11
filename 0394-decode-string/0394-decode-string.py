class Solution:
    def decodeString(self, s):
        stack = []
        curr_num = 0
        curr_str = ""

        for ch in s:

            # If digit
            if ch.isdigit():
                curr_num = curr_num * 10 + int(ch)

            # Opening bracket
            elif ch == '[':
                stack.append((curr_str, curr_num))
                curr_str = ""
                curr_num = 0

            # Closing bracket
            elif ch == ']':
                prev_str, num = stack.pop()
                curr_str = prev_str + curr_str * num

            # Character
            else:
                curr_str += ch

        return curr_str