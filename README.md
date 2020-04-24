# Cryptography Tool/Analysis

use java CYAT --help to get the command options

# Usage referenced here for ease:
Format command as: java CYAT <cipher file> <flag> <keylenght> <key>
Keylength is needed for -poly, -split, -tc, and -all, key is only needed for -poly and -all
  
# Flags are: 
-all | -ic | -freq | -cc | -tc | -split | -poly | --help - Only one flag can be used at a time.

# Calcuates:
- IC aka Index of Coincidence (-ic flag )
- Letter Frequency aka how oftern a letter appears (-freq flag )

# Tests
- Transposition ciphers with a period of input key length (-tc flag )
- Polyalphabetic Ciphers with input key and key length (-poly flag )

# Produces
- The split alphabets of a polyalphabetic cipher based on key length (-split flag )
- The 26 possible ceaser cipher outputs (Trivial and more of a sanity check) (-cc flag )

# The '-all' Tag
runs through the following tests in order:
- IC Calc
- Freq Calc | Numbers & Graph
- Ceaser Cipher
- Transpos Cipher
- Splits alpha bets
- Tests key again polyalphabetic text
