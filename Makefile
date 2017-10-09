Target = sNesting.elf
#中间文件输出 , 需要手动新建
OBJDIR = obj
# default
TOOLCHAIN_LOC = 
CC = $(TOOLCHAIN_LOC)arm-none-eabi-gcc
AS = $(TOOLCHAIN_LOC)arm-none-eabi-as


CPUFLAG= -mcpu=cortex-m3 -mthumb -mfloat-abi=soft
#用户OBJS
USER_OBJS=
#用户库
#enable float printf
LIBS= -u _printf_float -lm
#STM32 CUBEREF 库路径
STM32CUBEREF_PATH=stm32f1_Nesting_cubemax

#ld连接文件
LD=\
-T$(STM32CUBEREF_PATH)/STM32F103CBTx_FLASH.ld

#文件搜寻路径列表
VPATH = . \
MainSrc \
MPU6050 \
MPU6050/eMPL \
$(STM32CUBEREF_PATH)/Src \
$(STM32CUBEREF_PATH)/Drivers/STM32F1xx_HAL_Driver/Src \
$(STM32CUBEREF_PATH)/Drivers/CMSIS/Device/ST/STM32F1xx/Source/Templates \
$(STM32CUBEREF_PATH)/Drivers/CMSIS/Device/ST/STM32F1xx/Source/Templates/gcc \ #asm

#c include
C_INCLUDE = . \
-IMainSrc \
-IMPU6050 \
-IMPU6050/eMPL \
-I$(STM32CUBEREF_PATH)/Inc \
-I$(STM32CUBEREF_PATH)/Drivers/STM32F1xx_HAL_Driver/Inc \
-I$(STM32CUBEREF_PATH)/Drivers/STM32F1xx_HAL_Driver/Inc/Legacy \
-I$(STM32CUBEREF_PATH)/Drivers/CMSIS/Include \
-I$(STM32CUBEREF_PATH)/Drivers/CMSIS/Device/ST/STM32F1xx/Include \

#编译器预定义宏
DEFINE= \
-DUSE_HAL_DRIVER \
-DSTM32F103xB\
-D__weak="__attribute__((weak))" \
-D__packed="__attribute__((__packed__))"\
-D_PRINTF_RDF_\

