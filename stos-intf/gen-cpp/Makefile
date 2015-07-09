THRIFT_VER =thrift-0.9.2
USR_DIR    =/home/lliu
THRIFT_DIR =${USR_DIR}/${THRIFT_VER}
INCS_DIRS  =-I${USR_DIR}/include -I${THRIFT_DIR}/include/thrift
LIBS_DIRS  =-L${USR_DIR}/lib -L${USR_DIR}/${THRIFT_VER}/lib
CPP_DEFS   =-D=HAVE_CONFIG_H
CPP_OPTS   =-Wall -O2
LIBS       =-lthrift

GEN_SRC    = CreateVolume_constants.cpp \
             CreateVolume_types.cpp   \
             VolumeOps.cpp \
             VolumeOps_server.skeleton.cpp
GEN_INC    = -I.

default: server client

server: VolumeOps_server.skeleton.cpp
    g++ ${CPP_OPTS} ${CPP_DEFS} -o CppServer ${GEN_INC} ${INCS_DIRS} ${GEN_SRC} ${LIBS_DIRS} ${LIBS}
