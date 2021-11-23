FROM rabbitmq:3-management
COPY ["rabbitmq_delayed_message_exchange-3.9.0.ez" , "/plugins/"]
RUN rabbitmq-plugins enable --offline rabbitmq_delayed_message_exchange