from collections import deque

class Solution:
    def zigzagLevelOrder(self, root):
        if not root:
            return []
        
        result = []
        dq = deque([root])
        reverse = False

        while dq:
            level = []
            for _ in range(len(dq)):
                if not reverse:
                    node = dq.popleft()
                    level.append(node.val)
                    if node.left: dq.append(node.left)
                    if node.right: dq.append(node.right)
                else:
                    node = dq.pop()
                    level.append(node.val)
                    if node.right: dq.appendleft(node.right)
                    if node.left: dq.appendleft(node.left)
            reverse = not reverse
            result.append(level)
        return result