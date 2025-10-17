CREATE TABLE workspaces (
    id UUID PRIMARY KEY,
    name VARCHAR(150),
    created_at TIMESTAMPTZ DEFAULT now(),
     updated_at TIMESTAMPTZ DEFAULT now()
);
