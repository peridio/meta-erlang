include erlang.inc
include erlang-${PV}.inc
require erlang-${PV}-manifest.inc

PR = "r0"

SRC_URI += "file://0001-Enable-x32-support-for-crypto-configure.patch \
            file://0002-Enable-the-correct-ifdef-branch-when-x32-is-enabled.patch \
            file://0001-Fix-incompatible-pointer-types.patch \
            file://0002-Fix-implicit-int.patch \
            file://0003-Fix-incompatible-pointer-type-ErlDrvPort.patch \
           "

FILESEXTRAPATHS:prepend := "${THISDIR}/files/27:"

OTP_BUILD_CONFIGURE_OPTS = "update_configure --no-commit"

EXTRA_OECONF:class-target += " --with-ssl-rpath=no"

PACKAGECONFIG = "pkgconfig"
PACKAGECONFIG:class-native = "pkgconfig"
PACKAGECONFIG:class-nativesdk = "pkgconfig wx observer"
