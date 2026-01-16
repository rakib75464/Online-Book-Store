close all;
clc;

fs = 5000;
fc = 10;
x1 = [1 0 1 1 1 0 1 0];
x2 = [1 1 0 1 0 1 0 1];
a1 = 2;
a2 = 1.5;
a0 = 0;

duration = length(x1) / fc;
t = 0:1/fs:duration;
carrier = sin(2 * pi * fc * t);

signal1 = zeros(1, length(t));
for i = 1:length(x1)
    if x1(i) == 1
        signal1((i-1)*fs/fc+1:i*fs/fc) = a1 * carrier((i-1)*fs/fc+1:i*fs/fc);
    else
        signal1((i-1)*fs/fc+1:i*fs/fc) = a0 * carrier((i-1)*fs/fc+1:i*fs/fc);
    end
end

signal2 = zeros(1, length(t));
for i = 1:length(x2)
    if x2(i) == 1
        signal2((i-1)*fs/fc+1:i*fs/fc) = a2 * carrier((i-1)*fs/fc+1:i*fs/fc);
    else
        signal2((i-1)*fs/fc+1:i*fs/fc) = a0 * carrier((i-1)*fs/fc+1:i*fs/fc);
    end
end

composite_signal = signal1 + signal2;

figure;
subplot(4,1,1);
stairs(0:length(x1)-1, x1, 'LineWidth', 2);
ylim([-0.5 1.5]);
xlabel('Digital Values');
ylabel('Amplitude');
title('Digital Signal X1');
grid on;

subplot(4,1,2);
stairs(0:length(x2)-1, x2, 'LineWidth', 2);
ylim([-0.5 1.5]);
xlabel('Digital Values');
ylabel('Amplitude');
title('Digital Signal X2');
grid on;

subplot(4,1,3);
plot(t, signal1);
ylim([-2.5 2.5]);
xlabel('Time (s)');
ylabel('Amplitude');
title('ASK of X1');
grid on;

subplot(4,1,4);
plot(t, signal2);
ylim([-2.5 2.5]);
xlabel('Time (s)');
ylabel('Amplitude');
title('ASK of X2');
grid on;

figure;
subplot(3,1,1);
plot(t, composite_signal);
xlabel('Time (s)');
ylabel('Amplitude');
title('Composite Modulated Signal');
grid on;

Am1 = 2;
Am2 = 3;
f = fs/2 * linspace(-1, 1, fs);
fc1 = 100;
fc2 = 170;
fm1 = 4;
fm2 = 5;

[num1, den1] = butter(5, [(fc1 - fm1 - 6) / (fs/2), (fc1 + fm1 + 6) / (fs/2)]);
bpf1 = filter(num1, den1, composite_signal);
[num2, den2] = butter(5, [(fc2 - fm2 - 6) / (fs/2), (fc2 + fm2 + 6) / (fs/2)]);
bpf2 = filter(num2, den2, composite_signal);

Cm1 = 1;
c1 = Cm1 * cos(2 * pi * fc1 * t);
Cm2 = 1;
c2 = Cm2 * cos(2 * pi * fc2 * t);

z1 = 2 * bpf1 .* c1;
z2 = 2 * bpf2 .* c2;

[num4, den4] = butter(5, (fm1 + 3) / (fs/2));
rec1 = filter(num4, den4, z1);
[num5, den5] = butter(5, (fm2 + 3) / (fs/2));
rec2 = filter(num5, den5, z2);

subplot(3,1,2);
plot(t, rec1);
xlabel('Time (s)');
ylabel('Amplitude');
title('Demodulated Signal X1');

grid on;
subplot(3,1,3);
plot(t, rec2);
xlabel('Time (s)');
ylabel('Amplitude');
title('Demodulated Signal X2');
grid on;