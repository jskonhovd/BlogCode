import winsound
import termcolor as T
from argparse import ArgumentParser
import time

Freq = 2500 # Set Frequency To 2500 Hertz
Dur = 1000 # Set Duration To 1000 ms == 1 second

parser = ArgumentParser(description="Timer")
parser.add_argument("--mn", help="Time in Mins",
                    type=int, default=5)

args = parser.parse_args()

def cprint(s, color, cr=True):
    if cr:
        print T.colored(s, color)
    else:
        print T.colored(s, color),

if __name__ == '__main__':
    print "Hello"
    t = args.mn
    count = 0 
    while(count < t):
        print "Hello"
        cprint("Started " + str(count) + "....", "green") 
        time.sleep(60)
        count = count + 1

    for item in range(5):
        time.sleep(1)
        print "Hello"
        cprint("BEEP", "green")
        winsound.Beep(Freq,Dur)

