## 1.4.1.  RPC and Security

   As with previous versions of NFS, the External Data Representation
   (XDR) and Remote Procedure Call (RPC) mechanisms used for the NFS
   version 4 protocol are those defined in [RFC1831] and [RFC1832].  To
   meet end to end security requirements, the RPCSEC_GSS framework
   [RFC2203] will be used to extend the basic RPC security.  With the
   use of RPCSEC_GSS, various mechanisms can be provided to offer
   authentication, integrity, and privacy to the NFS version 4 protocol.
   Kerberos V5 will be used as described in [RFC1964] to provide one
   security framework.  The LIPKEY GSS-API mechanism described in
   [RFC2847] will be used to provide for the use of user password and
   server public key by the NFS version 4 protocol.  With the use of
   RPCSEC_GSS, other mechanisms may also be specified and used for NFS
   version 4 security.

   To enable in-band security negotiation, the NFS version 4 protocol
   has added a new operation which provides the client a method of
   querying the server about its policies regarding which security
   mechanisms must be used for access to the server's filesystem
   resources.  With this, the client can securely match the security
   mechanism that meets the policies specified at both the client and
   server.

## 1.4.2.  Procedure and Operation Structure

   A significant departure from the previous versions of the NFS
   protocol is the introduction of the COMPOUND procedure.  For the NFS
   version 4 protocol, there are two RPC procedures, NULL and COMPOUND.
   The COMPOUND procedure is defined in terms of operations and these
   operations correspond more closely to the traditional NFS procedures.
