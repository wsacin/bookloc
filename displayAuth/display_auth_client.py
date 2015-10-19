# -*- coding: utf-8 -*-
import socket
import sys
import json

HOST = 'localhost'    # The remote host
PORT = 50008          # The same port as used by the server
s = None
for res in socket.getaddrinfo(HOST, PORT, socket.AF_UNSPEC, socket.SOCK_STREAM):
    af, socktype, proto, canonname, sa = res
    try:
        s = socket.socket(af, socktype, proto)
    except OSError as msg:
        s = None
        continue
    try:
        s.connect(sa)
    except OSError as msg:
        s.close()
        s = None
        continue
    break

if s is None:
    print('could not open socket')
    sys.exit(1)

auth_info = {'name':'','passwd':'','bookid':0}
auth_info['name'] = input('Name: ')
auth_info['passwd'] = input('Passwd: ')
auth_info['bookid'] = input('BookId: ')
json_auth_info = json.dumps(auth_info)

s.sendall(bytes(json_auth_info,'utf-8'))
#data = s.recv(1024)
s.close()

#print('Received', repr(data))
