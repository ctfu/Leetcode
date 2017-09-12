# Read from the file file.txt and output all valid phone numbers to stdout.
# The phone number has the pattern (XXX) XXX-XXXX or XXX-XXX-XXXX
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt
