## ShiftInputStream

ShiftInputStream(InputStream in, int offset)  
ShiftInputStream(InputStream in)

ShiftInputStream is a subclass of FilterInputStream and it is used for manipulating some characters contained in a stream. ShiftInputStream replaces the characters in alphabet (A - Z and a - z) with the ones circularly shifted by the specified offset. Note that non-alphabet characters are not changed. If the offset is not specified, then its value is assumed to be zero.

If the offset is positive, then it means right circular shift. For example, the stream “A12ZX abc#” and offset = 2 results in “C12BZ cde#”. If the offset is negative, then it means left circular shift. For example, the stream “A12ZX a#” and offset = -1 results in “Z12YW z#”.
