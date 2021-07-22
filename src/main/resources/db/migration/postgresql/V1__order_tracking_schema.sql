CREATE table tracked_orders.orders
(
    id uuid NOT NULL,
    tracked_order_id character varying (100) NOT NULL,
    organization character varying (64),
    payload jsonb,
    site_id character varying (50),
    updated_date timestamp without time zone
);
