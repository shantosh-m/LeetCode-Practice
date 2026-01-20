class TimeMap:

    def __init__(self):
        # Dictionary: Key -> List of [value, timestamp]
        # Example: "foo" -> [["bar", 1], ["bar2", 4]]
        self.store = {} 

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        # Since timestamps are strictly increasing, we can just append.
        # This is O(1) time.
        self.store[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.store.get(key, [])
        
        # Binary Search
        # We want the largest timestamp that is <= the requested timestamp
        l, r = 0, len(values) - 1
        
        while l <= r:
            mid = (l + r) // 2
            mid_val, mid_time = values[mid]
            
            if mid_time <= timestamp:
                res = mid_val  # This is a candidate, try to find a closer one (move right)
                l = mid + 1
            else:
                r = mid - 1    # Too big, move left
                
        return res

# ---------------------------------------------------------
# The "Main" Function Equivalent
# ---------------------------------------------------------
if __name__ == "__main__":
    # 1. Create the Object (The "Bridge" / "Car")
    # Just like 'new TimeMap()' in Java
    obj = TimeMap()

    # 2. Call methods on the object
    # Command: ["set", "foo", "bar", 1]
    obj.set("foo", "bar", 1)
    print("Set foo=bar at 1")

    # Command: ["get", "foo", 1]
    print(f"Get foo, 1: {obj.get('foo', 1)}") # Expected: "bar"

    # Command: ["get", "foo", 3]
    print(f"Get foo, 3: {obj.get('foo', 3)}") # Expected: "bar"

    # Command: ["set", "foo", "bar2", 4]
    obj.set("foo", "bar2", 4)
    print("Set foo=bar2 at 4")

    # Command: ["get", "foo", 4]
    print(f"Get foo, 4: {obj.get('foo', 4)}") # Expected: "bar2"

    # Command: ["get", "foo", 5]
    print(f"Get foo, 5: {obj.get('foo', 5)}") # Expected: "bar2"