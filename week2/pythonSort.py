import random
import time

# Create a list of 200 million items
my_list = [random.randint(1, 1000) for _ in range(200000000)]

# Record the start time
start_time = time.time()

# Sort the list in-place using list.sort()
my_list.sort()

# Record the end time
end_time = time.time()

# Calculate the elapsed time
elapsed_time = end_time - start_time

# Print the elapsed time in milliseconds
elapsed_time_ms = elapsed_time * 1000
print("Sorting took", elapsed_time_ms, "milliseconds")
my_list.sort()
