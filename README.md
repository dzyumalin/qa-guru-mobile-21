# Practice **Mobile automation #2**

**Launch tests in the terminal:**

* browserstack
> gradle clean test -DdeviceHost=browserstack

* local launch with Android emulator
> gradle clean test -DdeviceHost=local

* remote launch with Android device
> gradle clean test -DdeviceHost=device

* remote launch Web test 
> gradle clean test -DdeviceHost=selenoid

**Launch tests in the jenkins:**

* browserstack (browserstack)
> clean mobile -DdeviceHost=${DEVICE_HOST}

* launch Web test (selenoid) 
> clean web -DdeviceHost=${DEVICE_HOST}
